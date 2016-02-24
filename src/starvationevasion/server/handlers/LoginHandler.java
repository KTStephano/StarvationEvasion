package starvationevasion.server.handlers;


import starvationevasion.server.Worker;
import starvationevasion.server.Server;
import starvationevasion.server.model.Endpoint;
import starvationevasion.server.model.Request;
import starvationevasion.server.model.Response;
import starvationevasion.server.model.User;

public class LoginHandler extends AbstractHandler
{
  public LoginHandler (Server server, Worker client)
  {
    super(server, client);
  }

  @Override
  protected boolean handleRequestImpl (Request request)
  {
    if (request.getDestination() == Endpoint.LOGIN)
    {
      String uname = request.chomp();
      String pwd = request.chomp();

      boolean auth = authenticate(uname, pwd);
      if (auth)
      {
        m_response = new Response(server.timeDiff(), "SUCCESS");
      }
      else
      {
        m_response = new Response(server.timeDiff(), "FAIL");
      }
      getClient().send(m_response.toString());

      return true;
    }

    return false;
  }

  private boolean authenticate(String username, String password)
  {
    User s = server.getUserByUsername(username);
    if (s != null && s.getPassword().equals(password))
    {
      getClient().setUser(s);
      return true;
    }

    return false;
  }
}
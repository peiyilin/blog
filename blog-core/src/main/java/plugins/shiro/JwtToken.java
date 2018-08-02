package plugins.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author peiyilin-ds
 * @date 2018/8/2 16:32
 **/
public class JwtToken implements AuthenticationToken {

    /**
     * 密钥
     */
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

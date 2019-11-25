package DammAutomationFramework.data;

import lombok.Data;

@Data
public class UserDetails {

    public String name;
    public String lastName;
    public String email;
    public String password;
    public LocationDetails location;

}

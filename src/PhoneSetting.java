/**
 * @author Msaad Albryah
 *
 * Description: My phone cantact program.
 */

public class PhoneSetting {
private String name;
private String Number;



public PhoneSetting() {
name = "";
Number = "";
}

public PhoneSetting(String name, String number) {
this.name = name;
this.Number = number;
}

//setters
public void setName(String name) {
this.name = name;
}

public void setNumnber(String number) {
this.Number = number;
}


//getters
public String getName() {
return name;
}

public String getNumber() {
return Number;
}



}

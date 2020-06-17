package sun.annotation.orm;
@DBTable(name="Member")
public class Member {
	@SQLString(name="firstName")
String firstName;
	@SQLString(name="lastName")
String lastName;
	@SQLInteger(name="age")
Integer age;
	@SQLString(name="handle",constraints=@Constraints(primaryKey=true))
String handle;

static int memberCount;

public String getFirstName() {
	return firstName;
}

public String getLastName() {
	return lastName;
}

public Integer getAge() {
	return age;
}

public String getHandle() {
	return handle;
}



}

package sun.enumeration.complex;

import java.text.DateFormat;
import java.util.Date;
/*Java enums have a very interesting feature that allows you to give each enum instance
different behavior by creating methods for each one. To do this, you define one or more
abstract methods as part of the enum, then define the methods for each enum instance.
In this example, each enum instance
is being treated as the "base type" ConstantSpecificMethod but you get polymorphic
behavior with the method call getInfo( ).
*/
public enum Info {

	DATE_TIME {
		String getInfo() {
			return DateFormat.getDateInstance().format(new Date());
		}
	},
	CLASSPATH {
		String getInfo() {
			return System.getenv("CLASSPATH");
		}
	},
	VERSION {
		String getInfo() {
			return System.getProperty("java.version");
		}
	};
	
	abstract String getInfo();

}

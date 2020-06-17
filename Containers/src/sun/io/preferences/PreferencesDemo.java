package sun.io.preferences;

import java.util.prefs.Preferences;
/*When you run PreferencesDemo.java you’ll see that the UsageCount does indeed increment every time you run the program,
 *  but where is the data stored? There’s no local file that appears after the program is run the first time. 
 *  The Preferences API uses appropriate system resources to accomplish its task, and these will vary depending on the OS.
 *   In Windows, the registry is used (since it’s already a hierarchy of nodes with key-value pairs). 
 *   But the whole point is that the information is magically stored for you so that you don’t have to worry about how it works from one system to another.*/
public class PreferencesDemo {
public static void main(String[] args) throws Exception {
Preferences prefs = Preferences
.userNodeForPackage(PreferencesDemo.class);
prefs.put("Location", "Oz");
prefs.put("Footwear", "Ruby Slippers	");
prefs.putInt("Companions", 4);
prefs.putBoolean("Are there witches?", true);
int usageCount = prefs.getInt("UsageCount", 0);
usageCount++;
prefs.putInt("UsageCount", usageCount);
for(String key : prefs.keys())
System.out.println(key + ": "+ prefs.get(key, null));
// You must always provide a default value:
System.out.println("How many companions does Dorothy have? " +
prefs.getInt("Companions", 0));

//To clear the preferences from registry
prefs.removeNode();
}
}
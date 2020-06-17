package sun.enumeration.statemachine;
import static sun.enumeration.statemachine.Input.*;

import java.util.Arrays;
import java.util.EnumMap;
public enum Category {
	
	MONEY(COIN,RUPEES10,RUPEES20,RUPEES50,RUPEES100),
	ITEM_SELECTION(SOAP,SODA,CHIPS,TOOTHPASTE),
	QUIT_TRANSACTION(STOP_TRANSACTION),
	SHUTDOWN(STOP);
	
Input[] values;
private Category(Input... values) {
	this.values=values;
}
static EnumMap<Input, Category> map = new EnumMap<Input, Category>(Input.class);

static{
for(Category c : Category.values()){
	for(Input i : c.values){
		map.put(i, c);
	}
}
}

public static Category getCategory(Input im){
	return map.get(im);
}

}

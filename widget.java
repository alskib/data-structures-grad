//  Franklin Leung
package cosc5319.assignment2;

public class widget {
        // initially I had the idea to give unique IDs, but it wouldn't
        //      be able to test if my sort would work
	//private static int IDgenerator = 1000; 
	
	private int widgetID;
	private String description;
	private int price;
	
	public widget(int id, String description, int price) {
            this.widgetID = id;
            this.description = description;
            this.price = price;
            //IDgenerator++;
	}
        
        public int getWidgetID() {
            return this.widgetID;
        }
        
        public String getDescription() {
            return this.description;
        }
        
        public int getPrice() {
            return this.price;
        }
        
        public void setPrice(int pr) {
            this.price = pr;
        }
        
        public void setDescription(String desc) {
            this.description = desc;
        }
}
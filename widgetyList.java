//  Franklin Leung
package cosc5319.assignment2;

public class widgetyList {
	private widget[] array;
	private int n;
        private int initialSize;
	
	public widgetyList(int size) {
            array = new widget[size];
            n = 0;
            initialSize = size;
	}
	
	public void resetList() {
            array = new widget[initialSize];
            n = 0;
	}
        
	public boolean isEmpty() {
            return (n == 0);
	}
	
	public boolean isFull() {
            return (n == array.length);
	}
        
        public void printList() {
            System.out.println("Total number of items: " + n);
            if (isEmpty()) {
                System.out.println("List is empty!");
            } else {
                System.out.println("Num\tID\tDescription\tPrice");
                for (int i = 0; i < n; i++) {
                    System.out.println(i+1 + "\t" 
                            + array[i].getWidgetID() + "\t"
                            + array[i].getDescription() + "\t" 
                            + array[i].getPrice());
                }
            }
        }
        
        //  insert widgets via insertion sort
        public void insertWidget(widget w) {
            if (isFull() == false) {
                //  insertion sort
                if (isEmpty()) {
                    array[0] = w;
                } else if (w.getWidgetID() < array[n-1].getWidgetID()) {
                    for (int i = 0; w.getWidgetID() < array[i].getWidgetID() && i < n; i++) {
                        System.out.println("Going " + i);
                        shiftDown(array, i);
                        array[i] = w;
                        break;
                    }
                } else {
                    array[n] = w;
                }
                System.out.println("Inserted ID " + w.getWidgetID());
                n++;
            } else {
                System.out.println("Widget list is full! Ignoring insert.");
            }
	}
        
        //  shift items down (used primarily to make room for widget insertions)
        private void shiftDown(widget[] array, int pos) {
            System.out.println("Shifting from " + n + " to " + pos);
            for (int i = n-1; i >= pos; i--) {
                array[i+1] = array[i];
            }
        }
	
	public int numWidgets() {
            return n;
	}
	
        //  retrieve widget at front of array
        public widget getFirstWidget() { 
            return retrieveWidget(0);
        }
        
        //  retrieve widget at rear of array
        public widget getLastWidget() {
            return retrieveWidget(n-1);
        }
        
        //  retrieve widget from specific array position
        public widget retrieveWidget(int pos) { 
            widget temp;
            if (isEmpty() == false) {
                temp = array[pos];
                balance(array, pos);
                return temp;
            }
            return null;
	}
        
        //  access but do not remove widget from array
        public widget accessWidget(int pos) {
            return array[pos];
        }
	
        //  balance the array by filling holes made by retrieval/delete
	private void balance(widget[] array, int pos) { 
            if (pos < n) {
                n--;
                for (int i = pos+1; i < n+1; i++) {
                    array[i-1] = array[i];
                }
            }
	}
        
        //  delete widget at specified position
        public void deleteWidget(int pos) {
            if (isEmpty() == false) {
                balance(array, pos);
            } else {
                System.out.println("Array is already empty.");
            }
        }
}
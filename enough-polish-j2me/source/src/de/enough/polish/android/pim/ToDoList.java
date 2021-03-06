//#condition polish.android
// generated by de.enough.doc2java.Doc2Java (www.enough.de) on Wed Mar 25 13:56:47 CET 2009
package de.enough.polish.android.pim;

/**
 * <p>Represents a ToDo list containing ToDo items.
 * A ToDo List is responsible for determining which of the fields from a ToDo are
 * retained when a ToDo is persisted into the List. A ToDo List does not have to
 * retain all of the fields in a ToDo when the ToDo is persisted into the List.
 * See the ToDo interface for a description of the fields available for a specific
 * ToDo. The fields that are supported by a particular ToDo List can be queried
 * through the method <A HREF="../../../javax/microedition/pim/PIMList.html#isSupportedField(int)">
 * <CODE>PIMList.isSupportedField(int)</CODE></A>. If a field ID that is not
 * in the ToDo interface is provided as the parameter to the <A HREF="../../../javax/microedition/pim/PIMList.html#isSupportedField(int)">
 * <CODE>PIMList.isSupportedField(int)</CODE></A> method, a <code>java.lang.IllegalArgumentException</code>
 * is thrown.
 * </P>
 * <h3>Inherited Method Behavior</h3>
 * <p>A ToDoList only accepts objects implementing the ToDo interface as a parameter
 * to <A HREF="../../../javax/microedition/pim/PIMList.html#items(javax.microedition.pim.PIMItem)">
 * <CODE>PIMList.items(PIMItem)</CODE></A>). A <code>java.lang.IllegalArgumentException</code>
 * is thrown by this method if the input parameter does not implement the ToDo
 * interface.
 * </P>
 * <p>Enumerations returned by <A HREF="../../../javax/microedition/pim/PIMList.html#items()">
 * <CODE>PIMList.items()</CODE></A>, <A HREF="../../../javax/microedition/pim/PIMList.html#items(javax.microedition.pim.PIMItem)">
 * <CODE>PIMList.items(PIMItem)</CODE></A>, and <A HREF="../../../javax/microedition/pim/ToDoList.html#items(int, long, long)">
 * <CODE>items(int, long, long)</CODE></A> contain only objects implementing a
 * ToDo interface.</P>
 */
public interface ToDoList extends PIMList
{

	/**
	 * 
	 * Factory method to create a ToDo entry for this ToDo list. The ToDo is empty
	 * upon creation with none of its fields containing any data (i.e. a call to the
	 * method <code>ToDo.getFields()</code> returns an array of zero length). Even
	 * though it is initially empty, the ToDo is <i>capable</i> of containing data for
	 * exactly those fields that this list supports. Note that creation of the ToDo
	 * does not add the ToDo to the list from which the item was created; a specific
	 * call to <code>PIMItem.commit()</code> must be made to commit the item and its
	 * data to the list.
	 * <P></P>
	 * 
	 * 
	 * 
	 * @return a new, empty ToDo object associated with this list. However, the ToDo is still not persistent in the list until a call to PIMItem.commit() for the ToDo is made.
	 */
	ToDo createToDo();

	/**
	 * 
	 * Imports the given ToDo into this list by making a new ToDo for the list and
	 * filling its information with as much information as it can from the provided
	 * ToDo. If the input ToDo is already an item of the list, a new ToDo is still
	 * created with information similar to the input item (but not necessarily
	 * identical).
	 * <P></P>
	 * <P>Note that not all data from the input ToDo may be supported in the new ToDo due
	 * to field restrictions for the list instance. In this case, data fields not
	 * supported are not transferred to the new ToDo object.
	 * </P>
	 * <P>Also note that creation of the ToDo does not add the ToDo to this list; a
	 * specific call to <code>PIMItem.commit()</code> must be made to commit the item
	 * and its data to the list.
	 * </P>
	 * <P></P>
	 * 
	 * 
	 * 
	 * @param item - the ToDo to import into the list.
	 * @return a newly created ToDo item.
	 * @throws java.lang.NullPointerException - If the input ToDo is null.
	 */
	ToDo importToDo( ToDo item);

	/**
	 * 
	 * Removes a specific ToDo from the list. The item must already exist in the list
	 * for this method to succeed.
	 * <P></P>
	 * 
	 * 
	 * 
	 * @param item - the ToDo to be removed from the list.
	 * @throws PIMException - If an error occurs deleting the item or the list is no longer accessible or closed.
	 * @throws java.lang.NullPointerException - If the ToDo is null.
	 * @throws java.lang.SecurityException - if the application is not given permission to write to the ToDo list or the list is opened READ_ONLY.
	 */
	void removeToDo( ToDo item) throws PIMException;

	/**
	 * 
	 * Return an enumeration of all the ToDos in the list where the value of the
	 * specified date field falls in the range from startDate to endDate inclusive.
	 * The field must have a data type of DATE. The items are in sorted and ascending
	 * order from the start date to the end date.
	 * <P></P>
	 * 
	 * 
	 * 
	 * @param field - the date field on which the matching is based. Must be ToDo.DUE or ToDo.COMPLETION_DATE.
	 * @param startDate - the inclusive start date to begin looking for todos on or after this date, returned in milliseconds since the epoch (00:00:00 GMT, January 1, 1970).
	 * @param endDate - the inclusive stop date to end looking for todos beyond this date, returned in milliseconds since the epoch (00:00:00 GMT, January 1, 1970).
	 * @return an enumeration of all the ToDos with specified date field between startDate and endDate
	 * @throws java.lang.IllegalArgumentException - If the data type of the field is not DATE (i.e. PIMList.getFieldDataType() for the field does not return PIMItem.DATE), or if endDate is less than startDate.
	 * @throws PIMException - If the operation is unsupported, an error occurs, or is no longer accessible or closed.
	 * @throws java.lang.SecurityException - if the application is not given permission to write to the ToDo list or the list is opened WRITE_ONLY.
	 */
	java.util.Enumeration items(int field, long startDate, long endDate) throws PIMException;

}

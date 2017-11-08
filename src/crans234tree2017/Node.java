package crans234tree2017;

public class Node 
{
    private int ORDER = 4;
    private int elementsNum;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private Item[] itemArray = new Item[ORDER - 1];
    
    /******************************************************
    ‘***  connectChild
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Connects the child to the node
    ‘*** 
    ‘* 
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public void connectChild(int childNum, Node child)
    {
        childArray[childNum] = child;
        if(child != null)
            child.parent = this;
    }
    
    /******************************************************
    ‘***  disconnectChild
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Returns the node removed and sets the space null
    ‘***
    ‘*** 
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public Node disconnectChild(int childNum)
    {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        
        return tempNode;
    }
    
    /******************************************************
    ‘***  getChild
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** gets child
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public Node getChild(int childNum)
    {
        return childArray[childNum];
    }
    
    /******************************************************
    ‘***  getParent
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** gets parent. Wow
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public Node getParent()
    {
        return parent;
    }
    
    /******************************************************
    ‘***  isLeaf
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** tests if there are any children
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public boolean isLeaf()
    {
        boolean isLeaf = false;
        if(childArray[0] == null)
            isLeaf = true;
        return isLeaf;
    }
    
    /******************************************************
    ‘***  getNumItems
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** returns how many items are in the array
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public int getNumItems()
    {
        return elementsNum;
    }
    
    /******************************************************
    ‘***  getItem
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** returns what is in the sent index
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public Item getItem(int index)
    {
        return itemArray[index];
    }
    
    /******************************************************
    ‘***  isFull
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** tests if the node is full.
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public boolean isFull()
    {
        boolean isFull = false;
        if(elementsNum == (ORDER - 1))
            isFull = true;
        return isFull;
    }
    
    /******************************************************
    ‘***  findItem
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** finds the index of the key. returns -1 if item is not in array
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public int findItem(String key)        
    {                       
        for(int i = 0; i < elementsNum - 1; i++)   
        {                              
            if(itemArray[i] == null)         
                break;
            else if(itemArray[i].getWord().compareTo(key) == 0)
                return i;
        }
        
        return -1;
    }
    
    /******************************************************
    ‘***  insertItem
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** insets an item object into the array
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public int insertItem(Item newItem)
    {
        elementsNum++;
        String newKey = newItem.getWord();
        
        for(int i = elementsNum - 1; i >= 0; i--)
        {
            if(itemArray[i] == null)
                continue;//i--;
            else
            {
                if(newKey.compareTo(itemArray[i].getWord()) < 0 )
                {
                    itemArray[i + 1] = itemArray[i];
                }
                else
                {
                    itemArray[i + 1] = newItem;
                    return (i + 1);
                }
            } 
        }
        itemArray[0] = newItem;
            
        return 0;
    }
    
    /******************************************************
    ‘***  removeItem
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** removes item
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public Item removeItem()
    {
        Item temp = itemArray[elementsNum - 1];
        itemArray[elementsNum - 1] = null;
        elementsNum--;
        
        return temp;
    }  
    
    /******************************************************
    ‘***  displayNode
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** returns the elements i nthe node in a string
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public String displayNode() 
    {
        String display = "";
        for(int j = 0; j <= elementsNum - 1; j++)
            display += itemArray[j].getWord() + "\n"; 
        
        return display;
    }
}

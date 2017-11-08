package crans234tree2017;

/*****************************************************
***  Tree234
***  Nick Crans
******************************************************
*** Holds all the values
*** 
******************************************************
*****************************************************/
public class Tree234
{
    private Node root;
    private int count;
    
    /******************************************************
    ‘***  Tree234
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Constructor
    ‘*** Initializes all the variables to there default 
    ‘*** values.
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public Tree234()
    {
        root = new Node();
        count = 0;
    }
    
    /******************************************************
    ‘***  insert
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Inserts a word into the tree. Supposed to skip
    ‘*** the whole insert structure if word is in tree, 
    ‘*** but as out put shows it does not. 
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public void insert(String word)
    {
        Node current = root;
        Node testDup = current;
        boolean inTree = find(word, testDup);
        Item temp = new Item(word);
        
        if(inTree)
        {
            count++;
        }
        else
        {
            while(true)
            {
                if(current.isFull())
                {
                    splitNode(current);
                    current = current.getParent();
                    current = getNextChild(current, word);
                }
                else if(current.isLeaf())
                    break;
                else
                {
                    current = getNextChild(current, word);
                }
            }
            current.insertItem(temp);  
            count++;
        }  
    }
    
    /******************************************************
    ‘***  splitNode
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Splits the node if it is full. Creates new right
    ‘*** 
    ‘*** 
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public void splitNode(Node fullNode)
    {
        Item middleItem, rightMostItem;
        Node parent, secondChild, thirdChild;
        int itemIndex;
        
        rightMostItem = fullNode.removeItem();
        middleItem = fullNode.removeItem();
        secondChild = fullNode.disconnectChild(2);
        thirdChild = fullNode.disconnectChild(3);
        
        Node newRight = new Node();
        
        if(fullNode == root)
        {
            root = new Node();
            parent = root;
            root.connectChild(0, fullNode);
        }
        else
        {
            parent = fullNode.getParent();
        }
        
        itemIndex = parent.insertItem(middleItem);
        
        for(int i = parent.getNumItems() - 1; i > itemIndex; i--)
        {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i + 1 , temp);
        }
        
        parent.connectChild(itemIndex + 1, newRight);
        
        newRight.insertItem(rightMostItem);
        newRight.connectChild(0, secondChild);
        newRight.connectChild(1, thirdChild);
    }

    /******************************************************
    ‘***  find
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Starts the recursive find process
    ‘*** 
    ‘*** 
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public boolean find(String key, Node test)
    {
        return recFind(test, key);
    }
    
    /******************************************************
    ‘***  getCount()
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Returns the count of the tree
    ‘***  
    ‘*** 
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public int getCount()
    {
        return count;
    }
    
    /******************************************************
    ‘***  recFind
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Meant to find duplicates, but doesnt work
    ‘*** 
    ‘***  
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    private boolean recFind(Node current, String key)
    {
        if(current.isLeaf())
            return false;
        
        if(current.findItem(key) != -1)
            return true;
        
        return recFind(getNextChild(current, key), key);
    }
   
    /******************************************************
    ‘***  findNextChild
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Returns the next child attached to the node
    ‘***  
    ‘*** 
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public Node getNextChild(Node aNode, String aWord)
    { 
        int j;
       
        int numItems = aNode.getNumItems();
        for(j = 0; j < numItems; j++)         
        {                              
            if(aWord.compareTo(aNode.getItem(j).getWord()) <  0)
                return aNode.getChild(j);  
        }                   
        return aNode.getChild(j);       
    }
    
    /******************************************************
    ‘***  displayTree
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Starts recursive display
    ‘*** 
    ‘*** 
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    public String displayTree()
    {
        return recDisplayTree(root);
    }

    /******************************************************
    ‘***  recDisplayTree
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Fills tree with the values in the tree recursivly. 
    ‘******************************************************
    ‘*** ??
    ‘******************************************************/
    private String recDisplayTree(Node thisNode)
    {   
        String display = "";
        if(thisNode != null && thisNode.isLeaf())
        {
            display = thisNode.displayNode();
            return display;
        }
        
        if(thisNode == null)
            return "";
        else
        {
            for(int i = 0; i <= thisNode.getNumItems(); i++)
            {
                Node temp = thisNode.getChild(i);
                display += recDisplayTree(temp);
                
            }
        }
                    
        return display;
    } 
}
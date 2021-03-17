/**
 * Personal implementation of ArrayList data structure.
 */
class ArrayList
{
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private double[] array = new double[DEFAULT_CAPACITY];

    /**
     * Empty constructor.
     */
    public ArrayList()
    {
    }

    /**
     * Setter for size, used internally in class.
     * @param size new size of array to set size field to.
     */
    private void setSize(int size)
    {
        this.size = size;
    }

    /**
     * Getter for size.
     * @return returns size.
     */
    public int getSize()
    {
        return this.size;
    }

    /**
     * Getter for DEFAULT_CAPACITY.
     * @return returns DEFAULT_CAPACITY.
     */
    private int getDefaultCapacity()
    {
        return DEFAULT_CAPACITY;
    }

    /**
     * Setter for array.
     * @param array new array to store.
     */
    private void setArray(double[] array)
    {
        this.array = array;
    }

    /**
     * Getter for array.
     * @return returns a double[].
     */
    public double[] getArray()
    {
        return this.array;
    }

    /**
     * Adds an element to end of the array.
     * @param element element to add to the array.
     */
    public void add(double element)
    {
        int currentSize = this.getSize();
        if(currentSize == getArray().length)
        {
            this.expandArray();
        }
        this.SetIndex(currentSize, element);
        this.setSize(currentSize+1);
    }

    /**
     * used to expand the array if the current array fills up completely.
     */
    private void expandArray()
    {
        int newSize = getArray().length + getDefaultCapacity();
        double[] newArray = new double[newSize];
        System.arraycopy(this.getArray(), 0, newArray, 0, this.getSize());
        this.setArray(newArray);
    }

    /**
     * Used to set a value for a valid index, upto and including 1 element past the last index used.
     * @param index index value to set.
     * @param element value to set at the given index value.
     */
    public void SetIndex(int index, double element) throws ArrayIndexOutOfBoundsException
    {
        if(index < 0 || index > this.getSize())
        {
            throw new ArrayIndexOutOfBoundsException("The index is out of bounds.");
        }

        double[] array = this.getArray();
        array[index] = element;
        this.setArray(array);
    }

    /**
     * gets element at index specified, zero-indexing used.
     * @param index index at which to get element.
     * @return returns element at the specified index.
     */
    public double getIndex(int index) throws ArrayIndexOutOfBoundsException
    {
        if(index < 0 || index >= this.getSize())
        {
            throw new ArrayIndexOutOfBoundsException("The index is out of bounds.");
        }
        double[] array = this.getArray();
        return array[index];
    }

    /**
     * Utility function used to print array stored.
     */
    public void printArray()
    {
        for(int i = 0; i < this.getSize(); i++)
        {
            double element = this.getIndex(i);
            System.out.println(element);
        }
    }

}
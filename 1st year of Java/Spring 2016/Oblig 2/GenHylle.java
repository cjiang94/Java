public interface GenHylle<T>{ // A generic interface.

  // ALl the methods in the interface.
  public int getArraySize();

  public boolean freeSpace(int i);

  public boolean put(T thingie, int placement);

  public boolean get(int placement);

}

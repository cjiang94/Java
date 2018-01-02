public class Hylle<T> implements GenHylle<T>{ // The class Hylle<T> that implements the interface GenHylle<T>

  // Making a private array variable
  private T[] array;

  // The constructor where I make a new Hylle with a number in places.
  public Hylle(int a){
    array = (T[]) new Object[a];
  }

  // A method that returns the Array size.
  public int getArraySize(){
    return array.length;
  }

  // A method that returns a boolean if whether the mentioned place is free or not.
  public boolean freeSpace(int i){
    if(array[i] == null){
      return true;
    }
      return false;

  }

  // A method where you can put a "thingie" in a place.
  public boolean put(T thingie, int placement){
    if(placement>=0 && placement<getArraySize() && freeSpace(placement) == true){
      array[placement] = thingie;
      return true;
    }
    return false;
  }

  // A method where you can remove the thingie on the specific place.
  public boolean get(int placement){
    if (placement>=0 && placement<getArraySize() && freeSpace(placement) == false){
    array[placement] = null;
    return true;
    }
    return false;
  }
}

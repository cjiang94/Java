/** Objektene av klassen som implementerer dette grensesnittet skal kunne laane
* bort og kunne ta tilbake et objekt av typen Bok.
*
* @author Christin Jiang
* versjon 08.02.2016
*/

public interface TilUtLaan {
/**
* Gjor at en laaner laaner en bok
*
*@param bok   boken som skal laanes bort
*@param laaner    laaneren som skal laane boken
*/
  public void LaaneBort(Bok bok, String laaner);
/**
*Gjor at en laaner kan levere tilbake boken de laante
*
*@param bok   boken som skal leveres tilbake
*/
  public void TaTilbake(Bok bok);

}

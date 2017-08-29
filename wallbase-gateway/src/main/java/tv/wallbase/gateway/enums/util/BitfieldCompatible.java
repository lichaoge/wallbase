package tv.wallbase.gateway.enums.util;

public interface BitfieldCompatible
{
   // Enums implicitly extend java.lang.Enum which implements ordinal()
   int ordinal();

   default long getBitfieldValue()
   {
      return 1 << ordinal();
   }
}

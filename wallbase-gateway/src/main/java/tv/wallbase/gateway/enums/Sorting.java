package tv.wallbase.gateway.enums;

public enum Sorting {
   RELEVANCE, RANDOM, DATE_ADDED, VIEWS, FAVORITES;

   @Override
   public String toString()
   {
      return name().toLowerCase();
   }
}

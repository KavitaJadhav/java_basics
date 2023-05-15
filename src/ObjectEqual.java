import java.util.Objects;

public class ObjectEqual {
    static class City{
        private String name;
        private Long population;

        public City(String name, Long population) {
            this.name = name;
            this.population = population;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            City city = (City) o;
            return Objects.equals(name, city.name) && Objects.equals(population, city.population);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, population);
        }
    }

    public static void main(String[] args) {
        City paris = new City("Paris", 10000l);
        City parisCpy = new City("Paris", 10000l);
        System.out.println(paris.equals(parisCpy));
    }
}

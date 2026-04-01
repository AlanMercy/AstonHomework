package ru.aston.hometasks.dz3.builder;

public class Animal {
    private final String name;
    private final String species;
    private final int age;
    private final double height;
    private final double weight;
    private final String breed;
    private final String color;
    private final String favoriteFood;
    private final String gender;
    private final String temper;

    private Animal(Builder builder) {
        this.name = builder.name;
        this.species = builder.species;
        this.age = builder.age;
        this.height = builder.height;
        this.weight = builder.weight;
        this.breed = builder.breed;
        this.color = builder.color;
        this.favoriteFood = builder.favoriteFood;
        this.gender = builder.gender;
        this.temper = builder.temper;
    }

    public static Builder builder(String name, String species) {
        return new Builder(name, species);
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String getGender() {
        return gender;
    }

    public String getTemper() {
        return temper;
    }

    @Override
    public String toString() {
        return String.format("Animal{name='%s', species='%s', age=%d, height=%.1f, weight=%.1f, breed='%s', color='%s', favoriteFood='%s', gender='%s', temper='%s'}",
                name, species, age, height, weight, breed, color, favoriteFood, gender, temper);
    }

    public static class Builder {
        private final String name;
        private final String species;

        private int age = 0;
        private double height = 0.0;
        private double weight = 0.0;
        private String breed = "неизвестно";
        private String color = "неизвестно";
        private String favoriteFood = "неизвестно";
        private String gender = "неизвестно";
        private String temper = "неизвестно";

        private Builder(String name, String species) {
            this.name = name;
            this.species = species;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder breed(String breed) {
            this.breed = breed;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder favoriteFood(String favoriteFood) {
            this.favoriteFood = favoriteFood;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder temper(String temper) {
            this.temper = temper;
            return this;
        }

        public Animal build() {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Имя не может быть пустым");
            }
            if (species == null || species.trim().isEmpty()) {
                throw new IllegalArgumentException("Вид не может быть пустым");
            }
            return new Animal(this);
        }
    }
}

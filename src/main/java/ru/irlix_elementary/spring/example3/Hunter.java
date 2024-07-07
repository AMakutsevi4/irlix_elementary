package ru.irlix_elementary.spring.example3;

public class Hunter {
    private String name;
    private String Weapon;
    private Animal currentAnimal;

    public Hunter() {
    }

    public Hunter(String name, String weapon) {
        this.name = name;
        Weapon = weapon;
    }


    /*Метод для назначения имени */
    public void setCurrentAnimal(Animal currentAnimal) {
        this.currentAnimal = currentAnimal;
    }

    public void killAnimal() {
        /*Выводим имя животного, в которого стреляем*/
        System.out.println("I'm shooting in " + currentAnimal.getName());
        System.out.println("I hit it with a gun!");
        /*Произносим звук животного*/
        currentAnimal.sayBeforeDeath();
    }

    @Override
    public String toString() {
        return "Hunter{"
            +    "name='" + name + '\''
            +    ", Weapon='" + Weapon + '\''
            +    '}';
    }
}

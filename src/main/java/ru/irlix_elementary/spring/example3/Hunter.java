package ru.irlix_elementary.spring.example3;

public class Hunter {
    private Animal currentAnimal;

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
}

package a1013.ani3;

class Animal implements Dog, Cat {

    @Override
    public void crying() {
        System.out.println("동물이 울음");
    }

    @Override
    public void one() {
        System.out.println("One");
    }

    @Override
    public void two() {
        System.out.println("Two");
    }
}

package company.apple;

public class AppleWeight implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 200;
    }
}//5

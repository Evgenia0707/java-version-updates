package company.apple;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Apple {

    private Integer weight;
    private Color color;//constant ->enum

}//2
/*
In software engineering, user requirements will change.
Example : Imagine an application to help a farmer understand his inventory.
- Find all green apples in the inventory
- Find all apples heavier than 200 g
As a developer, we have to minimize our engineering effort.
 */
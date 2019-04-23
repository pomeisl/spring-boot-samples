## @Embedded, @Embeddable

With @Embeddable and @Embedded annotation, we can embed an entity into an another one.

### @Embeddable
This annotation should be used on the embeddable classes.

**Example class**
```
@Embeddable
class Name {
    private String firstName;
    private String lastName;
}
```

### @Embedded
This annotation marks a field, the type of which is an embeddable class.

**Class**
```
@Entity
class User {
    ...
    @Embedded
    private Name name;
}
```

**Table representation**

| Column | Type |
| --- | --- |
| FIRST_NAME | VARCHAR |
| LAST_NAME | VARCHAR |

### @AttributeOverride

This annotation overrides the column names which come from the embedded class' field definitions.

**Class**
```
@Entity
class User {
    ...
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "F_NAME")),
            @AttributeOverride(name = "lastName", column = @Column(name = "L_NAME"))
    })
    private Name name;
}
```

**Table representation**

| Column | Type |
| --- | --- |
| F_NAME | VARCHAR |
| L_NAME | VARCHAR |

### @AttributeOverrides

This annotation contains multiple @AttributeOverride annotations.

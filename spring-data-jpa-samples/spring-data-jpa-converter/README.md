## @Convert, @Converter, AttributeConverter

An attribute converter allow us to specify a data transformation process to store and extract data from the database.

```
@Converter
public class CustomConverter implements AttributeConverter<EntityAttribute, DatabaseColumn> {
    
    public DatabaseColumn convertToDatabaseColumn(EntityAttribute attribute) {
        ...
    }

    public EntityAttribute convertToEntityAttribute(DatabaseColumn dbData) {
        ...
    }
}
```

You have to use the attribute converter to a specific field in the entity because the auto apply is false by default.

```
public class Entity {
    ...
    @Convert(converter = CustomConverter.class)
    EntityAttribute attribute;
}
```

With auto apply you don't need to use the @Convert annotation on the entity's attributes.

```
@Converter(autoApply = true)
public class CustomConverter implements AttributeConverter<EntityAttribute, DatabaseColumn> {
    ...
}
```

```
public class Entity {
    ...
    EntityAttribute attribute;
}
```

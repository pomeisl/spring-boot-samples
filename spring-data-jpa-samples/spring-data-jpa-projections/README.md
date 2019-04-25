## Spring Data Jpa - Projection

There are three type of projections.

* Closed projections
* Open projections
* Class-based projections
* Dynamic projections

**Example entity**
```
@Entity
class RootEntity {
    ...
    private String field1;
    private String field2;
    ...
}
```

### Closed projections

This is an interface based projection. We can reduce the requested fields in the select operation.

```
interface ProjectionInterface {
    String getField1();
}
```

### Open projections

This projection is interface based which we can specify the runtime computed returned values with the combination of the entity fields.  

```
interface ProjectionInterface {
    ...
    @Value("#{target.field1 + ' ' + target.field2}")
    String getConcatenatedFields();
}
```

## Class-based projections

In a projection class fields should match with the fields of the root entity.

```
class ProjectionClass {
    private String field1;
    ...
}
```

### Dynamic projection

We can define the methods in the repository with a Class parameter.

```
<T> T findByField(String field, Class<T> type);
```

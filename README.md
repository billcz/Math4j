Math4j is a simple java lib for matrix calculation that does not use third-party libs.

## Examples
### Matrix create
```java
        Matrix m1 = Matrix.create(4, 4);
        System.out.println(m1);
        System.out.println(m1.get(0,1));

        Matrix m2 = Matrix.zeros(4,4);
        m2.set(3.0, 1, 1);
        System.out.println(m2);

        Matrix m3 = Matrix.random(3, 4);
        System.out.println(m3);

        Matrix m4 = Matrix.random(4, 4);
        System.out.println(m4);
```
### Matrix calculation
```java
        System.out.println(m1.add(m2));
        System.out.println(m1.subtract(m2));
        System.out.println(m3.multiply(m4));
```

### Matrix block
```java
        System.out.println(m1.getMatrix(2, 2));
        System.out.println(m1.getMatrix(Matrix.DIMENSION_WILDCARD, 2));
        System.out.println(m1.getMatrix(2, Matrix.DIMENSION_WILDCARD));
```

Have fun~
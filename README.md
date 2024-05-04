## Explenation

First thing i did was t omake a class `ArithmeticParser` witch has properties `input` - the expression that was entered; and `index` - witch hepls us go through the expression and parse it.  
The class has one public method `parse()` and it sets up the properties and calls another method `parseExpression()`.  
That method then figures out which type of expression has been inputed and proseeds to call relevant methods.  
If the string is not done parsing the program recursivly calls more functions to parse the expression.

### Testing

Another class `ArithmeticParserTest` is used to run test for the progam.  
I imported the JUnit library for testing and created methods with the `@Test` annotation that will run the program and test if it gives teh correct value.

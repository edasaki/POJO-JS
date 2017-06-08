# POJO-JS
A Java annotation suite that facilitates automatic generation of Javascript/Typescript interfaces directly mapping to POJOs (Plain Old Java Objects).

This project was originally for creating a webgame with a Java backend and Typescript frontend in order to sync the Java entity representation classes with Typescript interfaces to be read through JSON.

## Work in Progress

This project is a work in progress. Eventually it is intended to be much more flexible (JSON output, configurations, include JS snippets, etc.).

### Example

    @JSObject
    public class SomeObject {
        @JSProperty(JSType.STRING)
        public String blah = "hi";

        @JSProperty(JSType.NUMBER)
        public int someVal = 5;

        @JSProperty(JSType.NUMBER)
        public double someDouble = 3.0;

        public SomeObject() {

        }
    }
    
Output:

    interface SomeObject {
        blah: string,
        someDouble: number,
        someVal: number,
    }

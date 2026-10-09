# No Infer

Disable Redundant Type Argument Inspection for certain methods.

<iframe width="245px" height="48px" src="https://plugins.jetbrains.com/embeddable/install/34210"></iframe>

## Usage

1. Install this plugin.
2. a) Create an annotation `cn.elytra.no_infer.NoInfer`.\
   b) Or import `cn.elytra:no-infer:1.0.0` from Maven Central.
3. Annotate the methods whose generic type should not be auto-inferred.

```kotlin
@NoInfer // <- no infer mark
fun <T> identify(value: T): T = value

val v: String = identify<String>("The String")
//                      ^^^^^^^^ automatically inferrable from type of v
// it's redundant by default,
// but since the function is marked with no infer, IDEA would expect it to be explicitly marked.
```

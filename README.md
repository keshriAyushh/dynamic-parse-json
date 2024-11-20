# Ktor Custom Deserializer 🧙‍♂️
Working with JSON APIs should be straightforward, right? Until *that one API* decides to spice things up by being wildly inconsistent with field types. 🤦‍♂️

---

## The Problem 👀

You're happily expecting the `"description"` field to be a `String`. But out of nowhere, **BOOM 💥**: `"description"` decides to show up as a `JSON Object`. Surprise! 🥳

### Example
```json
// What you expect
"description": "A summary here!"

// What you get
"description": { "summary": "A summary here!", "extra": "More details." }

Naturally, libraries like Retrofit and Volley are not amused.
They throw their hands up and say: "Sorry, I can’t turn that into a POJO/Kotlin data class without some serious help." 😤
```



# Enter Ktor with a Custom Deserializer! 🚀

With Ktor, you can tame even the most unruly APIs with a custom deserializer, transforming messy JSON into clean Kotlin data classes.

## What's in it for you?
- Consistency Is Key: No more "field type surprises" throwing off your flow.
- Kotlin-Only Party: Sorry, Java friends — this approach is exclusively for Kotlin developers. (It's just cooler here. 😎)
- Clean, Usable Data Classes: Say goodbye to messy JSON decoding nightmares.

## How It Works ⚙️?
- Set up Ktor in your project.
  - Add the necessary Ktor and Kotlinx Serialization dependencies compatible with the Kotlin version that you're using.
- Add the custom deserializer.
- Sit back and watch as inconsistent JSON melts away into perfectly structured Kotlin objects. 🔥


### **Note: This solution is restricted to Kotlin. Java enthusiasts might need to join the Kotlin club or look elsewhere.**

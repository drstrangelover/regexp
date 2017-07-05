package regexp



open class Token(val value : String)

class RegExpToken(value: String) : Token(value)

class PlainTextToken(value: String) : Token(value)
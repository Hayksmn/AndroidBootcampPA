package homework3

import java.lang.ref.WeakReference
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class WeakReferenceDelegation<R, T>(value: T) : ReadWriteProperty<R, T?> {
    private var value: WeakReference<T?> = WeakReference(value)

    override fun getValue(thisRef: R, property: KProperty<*>): T? {
        println(
            """ Reference: ${thisRef},
            | ${property.name}: ${this.value.get()}
            | Reference Type: ${this.value}""".trimMargin()
        )
        return this.value.get()
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: T?) {
        println(
            """ Before Value Change
            | Reference: ${thisRef},
            | ${property.name}: ${this.value.get()}
            | Reference Type: ${this.value}""".trimMargin()
        )
        this.value.clear()
        this.value = WeakReference(value)
        println(
            """ After Value Change
            | Reference: ${thisRef},
            | ${property.name}: ${this.value.get()}
            | Reference Type: ${this.value}""".trimMargin()
        )
    }

}

fun <R, T> weak(value: T): WeakReferenceDelegation<R, T> = WeakReferenceDelegation(value)
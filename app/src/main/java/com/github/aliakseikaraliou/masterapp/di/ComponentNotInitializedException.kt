package com.github.aliakseikaraliou.masterapp.di

import java.lang.Exception
import kotlin.reflect.KClass

class ComponentNotInitializedException(clazz: KClass<*>) :
    Exception("Component ${clazz.qualifiedName} is not initialized")

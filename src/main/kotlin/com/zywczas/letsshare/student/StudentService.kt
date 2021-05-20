package com.zywczas.letsshare.student

import org.springframework.stereotype.Service

@Service //to mowi ze ma byc wstrzykniete, dla ogolnych klas chyba powinno byc @Component
class StudentService {

    //todo tu umiesci logike biznesowa

    fun getStudents() = listOf(Student(), Student("Aga", 25))

}
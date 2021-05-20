package com.zywczas.letsshare.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import kotlin.IllegalStateException

@RestController
@RequestMapping("api/v1/student")
class StudentController @Autowired constructor(private val service: StudentService) {  //@Autowired jest jak @Inject

    @GetMapping(path = ["siema"])
    fun hello() = "siema"

    @GetMapping
    fun coTam() = listOf("co", "tam?")

    @GetMapping(path = ["students"])
    fun getStudents() = service.getStudents()

    @PostMapping(path = ["printNapis"])
    fun printNapis(@RequestBody napis: String){
            println("rzucam exception")
            throw IllegalStateException("Dzisiaj jest czwartek!")
        println(napis)
    }

    @PostMapping(path = ["printLiczba"])
    @DeleteMapping
    fun printLiczba(@RequestBody liczba: Int){
        println(liczba)
    }

    @PostMapping(path = ["printLiczba2/{liczba1}"])
    fun printLiczba2(@PathVariable("liczba1") liczba: Int){
        println(liczba)
    }

    @GetMapping(path = ["kombinacja"])
    fun getCombination(@RequestBody liczba: Int): String = "piatek $liczba"

}
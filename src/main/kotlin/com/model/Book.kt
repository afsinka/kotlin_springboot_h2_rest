package com.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Book(@Id val id:Long, val title:String)
package com.finderbar.omnihub.modules.core.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "core_employee")
class EmployeeEntity(

    @Column(
        name = "employee_no",
        nullable = false,
        unique = true,
        length = 100
    )
    var employeeNo: String,

    @Column(
        name = "first_name",
        nullable = false,
        length = 100
    )
    var firstName: String,

    @Column(
        name = "last_name",
        nullable = false,
        length = 100
    )
    var lastName: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "department_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_employee_department"
        )
    )
    var department: DepartmentEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "position_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_employee_position"
        )
    )
    var position: PositionEntity,

    @Column(length = 50)
    var phone: String? = null,

    @Column(length = 255)
    var email: String? = null,

    @Column(name = "hire_date")
    var hireDate: LocalDate? = null,

    @Column(nullable = false)
    var active: Boolean = true

) : BaseEntity()
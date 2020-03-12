
CREATE TABLE Instructor_detail (
                auto_id INTEGER NOT NULL,
                linkedIn VARCHAR(100) NOT NULL,
                skype VARCHAR(50) NOT NULL,
                CONSTRAINT instructor_detail_pk PRIMARY KEY (auto_id)
);


CREATE TABLE Instructor (
                registration INTEGER NOT NULL,
                name VARCHAR(50) NOT NULL,
                email VARCHAR(50) NOT NULL,
                detail_fk INTEGER NOT NULL,
                CONSTRAINT instructor_pk PRIMARY KEY (registration)
);


CREATE TABLE Course (
                code VARCHAR(10) NOT NULL,
                title VARCHAR(50) NOT NULL,
                instructor_reg_fk INTEGER NOT NULL,
                CONSTRAINT course_pk PRIMARY KEY (code)
);


CREATE TABLE Review (
                auto_id INTEGER NOT NULL,
                comment VARCHAR(200) NOT NULL,
                course_code_fk VARCHAR(10) NOT NULL,
                CONSTRAINT review_pk PRIMARY KEY (auto_id)
);


CREATE TABLE Student (
                registration INTEGER NOT NULL,
                name VARCHAR(50) NOT NULL,
                CONSTRAINT student_pk PRIMARY KEY (registration)
);


CREATE TABLE Enrollment (
                student_registry INTEGER NOT NULL,
                course_code VARCHAR(10) NOT NULL,
                CONSTRAINT enrollment_pk PRIMARY KEY (student_registry, course_code)
);


ALTER TABLE Instructor ADD CONSTRAINT instructor_detail_rel
FOREIGN KEY (detail_fk)
REFERENCES Instructor_detail (auto_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Course ADD CONSTRAINT instructor_course_rel
FOREIGN KEY (instructor_reg_fk)
REFERENCES Instructor (registration)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Review ADD CONSTRAINT course_review_rel
FOREIGN KEY (course_code_fk)
REFERENCES Course (code)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Enrollment ADD CONSTRAINT course_enrollment_rel
FOREIGN KEY (course_code)
REFERENCES Course (code)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Enrollment ADD CONSTRAINT student_enrollment_rel
FOREIGN KEY (student_registry)
REFERENCES Student (registration)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
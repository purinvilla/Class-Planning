[WHAT IS THIS?]
A Java software to manage class scheduling at universities.
- Shortens time needed to choose and register classes
- Helps to identify when two or more classes conflict with each other

[HOW TO RUN]
- java com.patricksak.classesPlanning.Main classData_input.txt > classSchedule_output.txt

[FORMAT OF classData_input.txt]
- Text document with strings following this template:
- "Id;Name;StartTime;EndTime;Days(mtwhfsu)"
- EXAMPLE: "84644;CS 4308/01 (M);14:00;15:15;m:w"

[TERMINOLOGY]
- [Id]: Class ID
- [Name]: Name of Class
- [StartTime]: Time that class starts at (24 hour format; schedule displays as 12 hour)
- [EndTime]: Time that class ends at (24 hour format; schedule displays as 12 hour)
- [Days]: The days you need to attend class (separate by colons)
--> "m" is Monday; "t" is Tuesday; "w" is Wednesday; "h" is Thursday; "f" is Friday; "s" is Saturday; "u" is Sunday

[FORMAT OF classSchedule_output.txt]
- Prints out class data following this format:
- "ID: XXXXX | Name: XXXXX | Start Time: XX:XX | End Time: XX:XX"
- Then, prints out schedule of classes
- Will show if two classes are clashing/share same time slot

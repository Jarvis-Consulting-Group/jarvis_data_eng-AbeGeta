# Introduction
The Java Grep application mimics the grep command found in Linux. It searches for a text pattern recursively in a designated directory and writes matching lines to a file. The program was created using IntelliJ IDEA, an IDE with capabilities for building Java applications with Maven. The core java package was employed for reading and writing files using BufferedWriter, Stream API, and Lambda functions to navigate directories and files and write lines to a file. To build the project, Maven is used to create a JAR file and manage dependencies such as SLF4J for logging. Docker was used to deploy the application using a Dockerfile.

# Quick Start
Run using Maven:
````bash
mvn clean compile package

java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp ${regex_pattern} ${src_dir} /out/${outfile}
````

Run using Docker:
````bash 
docker pull abegetachew99/grep

docker run --rm -v `pwd`/data:/data -v `pwd`/log:/log abegetachew99/grep ${regex_pattern} ${src_dir} /out/${outfile}
````

#Implemenation
## Pseudocode
````Python 
matchedLines = []

for file in listFilesRecursively(rootDir)
  for line in readLines(file)
      if containsPattern(line)
        matchedLines.add(line)
        
writeToFile(matchedLines)
````

## Performance Issue
An OutOfMemory exception is thrown when the JVM runs out of memory due to a large file and unable to allocate more memory for the new object. This happens because the application uses Lists to pass data. A possible solution is to use Streams instead of Lists, which would require a new interface.

# Test
The app was tested manually, using SLF4J to log errors. The output file was checked to see if the matching lines were written to the file correctly.

# Deployment
To dockerize the application, a JAR file was created using Maven and then put in the docker container. This results in a container you can run with the command above to execute the grep app.

# Improvement
1. Use Streams instead of Lists to pass data to increase performance
2. Create a simple GUI for people who are not comfortable with using command line
3. Add more specific exception handling
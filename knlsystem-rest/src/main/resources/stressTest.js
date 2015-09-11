if (arguments.length === 1) {

    var iterations = 1000;

    for (var i = 1; i <= iterations; i++) {

        println("Executing iteration " + i);
        exec("sh "+arguments[0]);

    }
}else{
    
    println("Usage: jrunscript stressTest.js pathToScriptToExecute.sh");
}

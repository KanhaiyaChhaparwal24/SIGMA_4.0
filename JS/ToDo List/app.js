let todo = [];
let req = prompt("Please enter ur request");

while(true){
    if(req == "quit"){
        console.log("quitting app!");
        break;
    }
    if (req == "list"){
        console.log("-----------------");
        for(let i = 0; i < todo.length; i++){
            console.log(i, todo[i]);
        }
        console.log("-----------------");
    }else if (req == "add"){
        let task = prompt("Please enter the task to be added");
        todo.push(task);
        console.log("task added");
    }else if (req == "delete"){
        let idx = prompt("Please enter the index to be deleted");
        todo.splice(idx, 1);
        console.log("task deleted");
    }else{
        console.log("Invalid request");
    }
    req = prompt("Please enter ur request");
}
printf "Enter marks for Subject 1: "
let m1 = int (System.Console.ReadLine())

printf "Enter marks for Subject 2: "
let m2 = int (System.Console.ReadLine())

printf "Enter marks for Subject 3: "
let m3 = int (System.Console.ReadLine())

printf "Enter marks for Subject 4: "
let m4 = int (System.Console.ReadLine())

let total = m1 + m2 + m3 + m4

let percentage = float total / 400.0 * 100.0

printfn "Total Marks = %d" total
printfn "Percentage = %.2f%%" percentage

let division =
    match percentage with
    | p when p >= 60.0 -> "First Division"
    | p when p >= 50.0 -> "Second Division"
    | p when p >= 40.0 -> "Third Division"
    | _ -> "Fail"

printfn "Division = %s" division
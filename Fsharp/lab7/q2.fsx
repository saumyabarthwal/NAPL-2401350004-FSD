
let list1 = [1; 2; 3; 4]
let list2 = [5; 6; 7]




let square1 = List.map (fun x -> x * x) list1
let square2 = List.map (fun x -> x * x) list2

printfn "Squares of List 1: %A" square1
printfn "Squares of List 2: %A" square2




let even1 = List.filter (fun x -> x % 2 = 0) list1
let even2 = List.filter (fun x -> x % 2 = 0) list2

printfn "\nEven numbers in List 1: %A" even1
printfn "Even numbers in List 2: %A" even2



let sum1 = List.fold (fun total x -> total + x) 0 list1
let sum2 = List.fold (fun total x -> total + x) 0 list2

printfn "\nSum of List 1: %d" sum1
printfn "Sum of List 2: %d" sum2




let product1 = List.reduce (fun total x -> total * x) list1
let product2 = List.reduce (fun total x -> total * x) list2

printfn "\nProduct of List 1: %d" product1
printfn "Product of List 2: %d" product2
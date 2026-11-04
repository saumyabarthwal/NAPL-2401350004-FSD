open System
open System.Text.RegularExpressions



let reverseString (str: string) =
    new string(Array.rev (str.ToCharArray()))

let isPalindrome (str: string) =
    str = reverseString str



let transformString (str: string) =
    if str |> Seq.forall Char.IsLetter then
        str.ToUpper()
    elif str |> Seq.forall Char.IsDigit then
        str + str
    else
        str

let isValidEmail (email: string) =
    Regex.IsMatch(email, @"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$")


printfn " STRING PROCESSING "

printfn "\nTask 1: Reverse and Palindrome"

let strings = ["hello"; "saumya"; "mam"]

for s in strings do
    printfn "String: %s" s
    printfn "Reversed: %s" (reverseString s)
    printfn "Palindrome: %b" (isPalindrome s)



printfn "\nTask 2: String Transformation"

let inputs = ["hello"; "1234"; "hello123"]

for s in inputs do
    printfn "Original: %s" s
    printfn "Transformed: %s" (transformString s)



printfn "\nTask 3: Email Validation"

let emails = [
    "abc@gmail.com"
    "student123@yahoo.com"
    "invalidemail"
]

for email in emails do
    if isValidEmail email then
        printfn "%s : Valid Email" email
    else
        printfn "%s : Invalid Email" email
from tkinter import *
import tkinter
from tkinter import messagebox

window = Tk()
window.title("Sign-up Sheet")
window.geometry('400x250')

entries = []

for i in range(5):
    if (i==1):
        entries.append(Entry(window, bd=5, show='*'))
    else:
        entries.append(Entry(window, bd=5))
    entries[i].grid(row=i,column=1)

#creating labels
username = Label(window,text='Username:').grid(row=0,column=0)
password = Label(window,text='Password:').grid(row=1,column=0)
email = Label(window,text='Email:').grid(row=2,column=0)
phone = Label(window,text='Phone #:').grid(row=3,column=0)
dob = Label(window,text='Date of Birth:').grid(row=4,column=0)

def Submit():
    res = []
    for i in range(5):
        res.append(entries[i].get())
        print(res[i])

register = Button(window,text="Enter",command=Submit).grid(row=5,column=1)
entries[0].focus()
window.mainloop()
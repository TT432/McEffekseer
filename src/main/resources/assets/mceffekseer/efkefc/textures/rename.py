import re
import os
import sys

def pascal_case_to_snake_case(camel_case):
    snake_case = re.sub(r"(?P<key>[A-Z])", r"_\g<key>", camel_case)
    temp = snake_case.lower().strip('_')
    return re.sub(r"(?P<key>__)", r"_", temp)

curr_path = sys.path[0]
a = os.walk(curr_path)

for file in os.listdir(curr_path):
    old = os.path.join(curr_path, file)
    if (os.path.isdir(old)):
        pass
    fileName = os.path.splitext(file)[0]
    fileType = os.path.splitext(file)[1]
    new = os.path.join(curr_path, pascal_case_to_snake_case(fileName) + fileType)
    os.rename(old, new)

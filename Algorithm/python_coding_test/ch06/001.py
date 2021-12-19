

class solution_001:
    def solution1(self, s:str) -> bool:
        strs = []

        for c in s:
            if c.isalnum():
                strs.append(c.lower())

        while len(strs) > 1:
            if strs.pop() != strs.pop(0):
                return False

        return True

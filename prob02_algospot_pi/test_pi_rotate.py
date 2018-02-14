import unittest

from prob02_algospot_pi.pi import rotate, subRotate


class RotateTestCase(unittest.TestCase):
    def test_1(self):
        self.assertEqual(rotate('323'), True)

    def test_2(self):
        self.assertEqual(rotate('3232'), True)

    def test_3(self):
        self.assertEqual(rotate('32323'), True)

    def test_4(self):
        self.assertEqual(rotate('232'), True)

    def test_5(self):
        self.assertEqual(rotate('2323'), True)

    def test_6(self):
        self.assertEqual(rotate('23232'), True)

    def test_7(self):
        self.assertEqual(rotate('234'), False)

    def test_8(self):
        self.assertEqual(rotate('432'), False)


    def test_sub_1(self):
        self.assertEqual(subRotate('1323', 3), True)

    def test_sub_2(self):
        self.assertEqual(subRotate('13232', 4), True)

    def test_sub_3(self):
        self.assertEqual(subRotate('132323', 5), True)

    def test_sub_4(self):
        self.assertEqual(subRotate('1232', 3), True)

    def test_sub_5(self):
        self.assertEqual(subRotate('12323', 4), True)

    def test_sub_6(self):
        self.assertEqual(subRotate('123232', 5), True)

    def test_sub_7(self):
        self.assertEqual(subRotate('3234', 3), False)

    def test_sub_8(self):
        self.assertEqual(subRotate('3432', 3), False)
